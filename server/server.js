

const functions = require('firebase-functions');
const express = require('express');
const app = express();
const port = 3000;

const admin = require('firebase-admin');
admin.initializeApp();

app.get('/', (req, res) => {
  res.send('Hello World!');
});

app.listen(port, () => {
  console.log('MyPOSservice app listening at http://localhost:${port}');
});



