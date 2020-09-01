

var express = require('express');
var app = express();
var firebase = require('firebase');
var bodyParser = require('body-parser');
var xmlHttpRequest = require("xmlhttprequest").XMLHttpRequest;
var port = 8080;

app.use(bodyParser.json());

var admin = require('firebase-admin');

// var serviceAccount = require("serviceAccountKey.json");

// console.log("serviceAccountKey " + serviceAccountKey);

// admin.initializeApp({
//   credential: admin.credential.cert(serviceAccount),
//   databaseURL: 'https://myposservice-1f675.firebaseio.com/'
// });

var config =  {
	apiKey: "AIzaSyDK51h_jaYHpFv7htNXELdXudCdCUWWxYg",
    authDomain: "myposservice-1f675.firebaseapp.com",
    databaseURL: "https://myposservice-1f675.firebaseio.com",
    projectId: "myposservice-1f675",
    storageBucket: "myposservice-1f675.appspot.com",
    messagingSenderId: "677547561004",
    appId: "1:677547561004:web:cff9504869510270c18189",
    measurementId: "G-TPYVXVZH69"
};
firebase.initializeApp(config);

// app.get('/', (req, res) => {
//   res.send('Hello World!');
// });

/** 
  Post endpoint of ticket 
  */
app.post('/ticket', (req, res) => {
	console.log('Receiving data ...');
	// console.log('TicketNumber: ' + req.body.ticketNumber);
	// console.log('StoreId: ' + req.body.storeId);
	// console.log('businessDate: ' + req.body.businessDate);
	// console.log('totalPrice: ' + req.body.totalPrice);

	let referencePath = '/Tickets';
	// let ticketRef = admin.database().ref(referencePath);
	let ticketRef = firebase.database().ref(referencePath);
	let newTicket = {Ticket : req.body};

	ticketRef.set(newTicket, 
		function(error) {
			if (error) {
				res.status(500);
			} else {
				let r = {message : "Ticket Created Successful"};
				res.status(201).send(r);
				console.log('Ticket Saved in database');
			}
		})
});

app.listen(port, () => {
  console.log(`MyPOSservice app listening at http://localhost:${port}`);
});



