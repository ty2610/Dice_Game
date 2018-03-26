var indexApp = angular.module('indexApp', []);

indexApp.controller('IndexController', function PhoneListController($scope) {

    $scope.show = function () {

    };

    $scope.submitNumber = function () {
        var send;
        var input = $("#simulationInput").val();
        var result;
        if ($scope.isNormalInteger(input)) {
            send = {
                sims: input
            };
            $.ajax({
                url: 'sendIt',
                data: send,
                type: 'GET',
                cache: false,
                contentType: "application/json; charset=utf-8",
                success: function (data) {
                    $scope.games = JSON.parse(data);
                    $("#simulationInput").val("");
                    $scope.$apply()
                },
                error: function () {
                    alert('error');
                }
            });
        } else {
            window.alert("You must enter an integer.");
        }
    };

    $scope.isNormalInteger = function (str) {
        var n = Math.floor(Number(str));
        return n !== Infinity && String(n) === str && n >= 0;
    };
});