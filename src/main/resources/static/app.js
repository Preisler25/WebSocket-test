var stompClient = null;

var socket = new SockJS('/stomp-endpoint');
stompClient = Stomp.over(socket);
console.log('socker', socket)
console.log('stomp', stompClient)
stompClient.connect({}, function (frame) {
    console.log('Connected: ' + frame);
    stompClient.subscribe('/topic/greetings', function (mess) {
        const obj = JSON.parse(mess)
        console.log("obj", obj.data)
    });
});


addEventListener('click', function (e) {
    console.log('click', e)
    console.log('click', e.screenX)
    stompClient.send("/app/click", {}, JSON.stringify({'x': e.screenX, 'y': e.screenY}));
});


