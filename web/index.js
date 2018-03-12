$(document).ready(function() {
    $("#testClick").click( function()
        {
            testerClick();
        }
    );
});

function testerClick() {
    var send;
    send = {
        stuff:"ayyyye",
        other:"naayyyyyy"
    };
    /*$.get(
        "\\src\\Demo\\ServiceReceiver.java",
        send, //meaasge you want to send
        function(result) {
            alert(result);
        });*/
    $.ajax({
        url: 'sendIt',
        data: send,
        type:'GET',
        cache: false,
        contentType: "application/json; charset=utf-8",
        success:function(data){
            alert(data);
        },
        error:function(){
            alert('error');
        }
    });
}