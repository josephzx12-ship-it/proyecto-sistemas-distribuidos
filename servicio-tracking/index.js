const express = require('express');
const app = express();
const http = require('http');
const server = http.createServer(app);
const { Server } = require("socket.io");
const io = new Server(server);

app.get('/', (req, res) => {
  res.sendFile(__dirname + '/index.html');
});

io.on('connection', (socket) => {
  console.log('Un usuario se ha conectado');

  // YA NO ESCUCHAMOS 'chat message'
  // AHORA ESCUCHAMOS EL EVENTO DEL REPARTIDOR
  socket.on('repartidor_actualiza_ubicacion', (coords) => {
    
    // Mostramos las coordenadas en la terminal del servidor
    console.log('Nuevas coordenadas recibidas:', coords);

    // Reenviamos las coordenadas a TODOS los clientes (el mapa)
    // con el evento 'tracking_actualizado'
    io.emit('tracking_actualizado', coords);
  });

  socket.on('disconnect', () => {
    console.log('Un usuario se ha desconectado');
  });
});

const PORT = 3000;
server.listen(PORT, () => {
  console.log(`Servidor de tracking escuchando en http://localhost:${PORT}`);
});