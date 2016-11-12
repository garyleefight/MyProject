/**
 * Created by lsr on 2016/11/11.
 */
var flickapi = require('flickrapi');
var flickoption={
    api_key: "305df9a6d1c16f634c44bbcafc61133f"
};

var result_photos=[];
var maxium_size=100;
var searchTag="beauty";

function getPhotos(callback) {
    flickapi.tokenOnly(flickoption,function (err,author) {
        author.photos.search({
            tags: searchTag,
            page: 2,
            per_page: maxium_size
        },function (err,result) {
            if(err){
                console.log(err);
                return;
            }

           var photos= result.photos.photo;
           var size=0;
            photos.forEach(function (photo) {
                var title=photo.title;
                var link=Link(photo.owner,photo.id);
                var src=Src(photo);
                add_des(author,photo.id,function (discription,tags) {
                    result_photos.push({
                        title: title,
                        link:   link,
                        src:    src,
                        des:    discription,
                        tags: tags,
                        originalIndex: size++
                    });

                    if(result_photos.length>=maxium_size){
                        callback();
                    }
                });


            })
        })
    })
}

function Link(userid,photoid){
    return 'https://www.flickr.com/photos/'+userid+'/'+photoid+'/';
    //https://www.flickr.com/photos/12037949754@N01/155761353/

}

function Src(photo){
    return 'https://farm'+photo.farm+'.staticflickr.com/'+photo.server+'/'+photo.id+'_'+photo.secret+'.jpg';
    //https://farm{farm-id}.staticflickr.com/{server-id}/{id}_{secret}.jpg
}

function add_des(author,photoid,callback){
    author.photos.getInfo({photo_id: photoid},function(err,result){
        var t=[];
         result.photo.tags.tag.forEach(function(tag){
            t.push(tag.raw);
        });
         discription=result.photo.owner.username;
         tags=t.join();
         callback(discription,tags);
    });
}

//output result
module.exports={
    getPhotos: getPhotos,
    result_photos: result_photos
};