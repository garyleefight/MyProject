var app = angular.module("myflickr", ['akoenig.deckgrid']);

app.controller("Mycontroller",["$http","$scope","$filter", function ($http,$scope,$filter) {
        $http.get("/photos")
            .then(function(response){
                // initial
                $scope.photos=response.data;
                $scope.filterphotos=$scope.photos;
                $scope.pin=false;
                $scope.search="";

                $scope.logic=function () {
                    if($scope.pin===false){
                        // show all
                        if($scope.searh===""){
                            $scope.filterphotos=$scope.photos;
                        }else{
                            $scope.filterphotos=$filter('filter')($scope.photos,{tags: $scope.search});
                        }
                    }else{
                        // show pin
                        if($scope.search===""){
                            $scope.filterphotos=$filter('filter')($scope.photos,{pinned: true});
                        }else{
                            $scope.filterphotos=$filter('filter')($scope.photos,{pinned: true,tags: $scope.search});
                        }
                    }
                };

                $scope.addfavor=function(index){
                    var flag=$scope.photos[index].pinned;
                    if(flag==null){
                        $scope.photos[index].pinned=true;
                    }else{
                        $scope.photos[index].pinned=!flag;
                    }

                    if($scope.pin==true){
                        if($scope.search===""){
                            $scope.filterphotos=$filter('filter')($scope.photos,{pinned: true});
                        }else{
                            $scope.filterphotos=$filter('filter')($scope.photos,{pinned: true,tags: $scope.search});
                        }
                    }
                };

                $scope.select=function(status){
                    $scope.pin=status;
                    if(status==false){
                        if($scope.search===''){
                            $scope.filterphotos=$scope.photos;
                        }else{
                            $scope.filterphotos=$filter('filter')($scope.photos,{tags: $scope.search})
                        }
                    }else{
                        if($scope.search===''){
                            $scope.filterphotos=$filter('filter')($scope.photos,{pinned: true})
                        }else{
                            $scope.filterphotos=$filter('filter')($scope.photos,{pinned:true,tags: $scope.search})
                        }

                    }
                };
            });
}]);
