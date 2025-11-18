// index.js
const express = require('express');
const http = require('http');
const { Server } = require("socket.io");
const path = require('path');
const cors = require('cors');

const app = express();
const server = http.createServer(app);
const io = new Server(server, {
    cors: {
        origin: "*",
        methods: ["GET", "POST"]
    }
});

app.use(cors());
app.use(express.json());
app.use(express.static(path.join(__dirname, 'public')));

// Rutas principales
app.get('/', (req, res) => {
    res.sendFile(path.join(__dirname, 'public', 'index.html'));
});

app.get('/usuarios', (req, res) => {
    res.sendFile(path.join(__dirname, 'public', 'usuarios.html'));
});

app.get('/facturas', (req, res) => {
    res.sendFile(path.join(__dirname, 'public', 'facturas.html'));
});

app.get('/tracking', (req, res) => {
    res.sendFile(path.join(__dirname, 'public', 'tracking.html'));
});

// WebSocket para tracking en tiempo real
let activeDeliveries = [];

io.on('connection', (socket) => {
    console.log('Cliente conectado:', socket.id);

    // Enviar entregas activas al nuevo cliente
    socket.emit('entregas-activas', activeDeliveries);

    // Actualizar ubicación de repartidor
    socket.on('actualizar-ubicacion', (data) => {
        const delivery = activeDeliveries.find(d => d.id === data.deliveryId);
        if (delivery) {
            delivery.lat = data.lat;
            delivery.lng = data.lng;
            delivery.lastUpdate = new Date();
        } else {
            activeDeliveries.push({
                id: data.deliveryId,
                lat: data.lat,
                lng: data.lng,
                repartidor: data.repartidor || 'Repartidor',
                estado: 'En camino',
                lastUpdate: new Date()
            });
        }
        io.emit('ubicacion-actualizada', data);
    });

    // Nuevo pedido
    socket.on('nuevo-pedido', (data) => {
        io.emit('pedido-creado', data);
    });

    // Marcar entrega como completada
    socket.on('completar-entrega', (deliveryId) => {
        activeDeliveries = activeDeliveries.filter(d => d.id !== deliveryId);
        io.emit('entrega-completada', deliveryId);
    });

    socket.on('disconnect', () => {
        console.log('Cliente desconectado:', socket.id);
    });
});

const PORT = process.env.PORT || 3000;
server.listen(PORT, () => {
    console.log(`🚀 Servidor corriendo en http://localhost:${PORT}`);
});