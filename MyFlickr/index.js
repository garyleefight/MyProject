var express = require('express');
var app=express();
var flickrloader=require('./dao/flickrloader');

flickrloader.getPhotos(function () {
    app.get('/photos',function(req,res){
        var photos=flickrloader.result_photos;
        res.json(photos);
    });
    app.use('/', express.static(__dirname + '/'));
    // heroku port
    app.listen(process.env.PORT || 5000);
    console.log("server starts!");
});


