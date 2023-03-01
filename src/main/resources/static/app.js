var stompClient = null;

var socket = new SockJS('/stomp-endpoint');
stompClient = Stomp.over(socket);
console.log('socker', socket)
console.log('stomp', stompClient)
stompClient.connect({}, function (frame) {
    console.log('Connected: ' + frame);
    stompClient.subscribe('/ws/trieng', function (mess) {
        let obj = JSON.parse(mess.body)
        let line = document.createElement('div')
        line.style.backgroundColor = 'red'
        line.style.position = 'fixed'
        line.style.top = obj.y + 'px'
        line.style.left = obj.x + 'px'
        line.style.border = '1px solid black'
        line.style.width = obj.length + 'px'
        line.style.height = '10px'
        line.style.rotate = obj.angle + 'deg'
        document.body.appendChild(line)
    });
});


addEventListener('click', function (e) {
    console.log('click', e)
    console.log('click', e.screenX)
    stompClient.send("/app/click", {}, JSON.stringify({'x': e.screenX, 'y': e.screenY}));
});


