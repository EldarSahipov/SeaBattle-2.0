let tds = document.querySelectorAll('td');

function add() {


                    $.get('/add', function (data) {
                        console.log(data)
                        var tds = document.getElementById('table1').getElementsByTagName('td');
                        var massiv = []

                        for (var i = 0; i < 10; i++)
                        {
                            for ( var j = 0; j < 10; j++) {
                                massiv.push(data[i][j]);
                            }
                        }
                        for (var i = 0; i < tds.length; i++){
                            if (massiv[i] == 1)
                            {
                                tds[i].className = 'greeny'
                            }
                        }
                    })

    document.getElementById("but").style.display="none";



}





document.querySelector('table').onclick = (event) => {

let cell = event.target;
if (cell.tagName.toLowerCase() != 'td')
    return;
let i = cell.parentNode.rowIndex;
let j = cell.cellIndex;
console.log(i, j);
//document.getElementById('d').innerHTML = `${i},${j}`

    var target = event.target;
    var str = i + "" + j
    $.get('/check_field/' + str, function (data) {
        if (target.tagName === 'TD') {

            if (data == 1) {
                target.classList.toggle('redy');
            }
            else {
                target.classList.toggle('grayy');
            }

        }
    })
}











/*

    tds.forEach((item) => {
        item.onclick = (e) => {
            var str = i + "" + j
            console.log(ij)
            $.get('/check_field/' + str, function (data) {
                console.log(data)
                if (data == 1)
                {
                    e.target.classList.toggle('redy')
                }
                else
                {
                    e.target.classList.toggle('grayy')
                }
            })

        }
    })
 */


























/*let tds = document.querySelectorAll('td');

tds.forEach((item) => {
    item.onclick = (e) => {
        $.get('/check_field/' + document.getElementById('d').innerHTML.value, function (data) {
            if (data == 1)
            {
                e.target.classList.toggle('redy')
            }
            else
            {
                e.target.classList.toggle('grayy')
            }
        })
    }
});

/*
function checkfield() {
    $.get('/check_field/' + document.getElementById('d').innerHTML.value, function (data) {
        if (data == 1) {
            let tds = document.querySelectorAll('td');
            tds.forEach((item) => {
                item.onclick = (e) => {
                    e.target.classList.toggle('grayy')
                }
            });
        }
        if (data == 0) {
            let tds = document.querySelectorAll('td');
            tds.forEach((item) => {
                item.onclick = (e) => {
                    e.target.classList.toggle('redy')
                }
            });
        }

    })
}*/

