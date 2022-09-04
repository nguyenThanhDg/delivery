/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */
function delGoToShipper(endpoint) {
    fetch(endpoint, {
        method: "delete"
    }).then(function (res) {
        if (res.status === 202)
            location.reload();
    }).catch(function (err) {
        console.error(err);
    });
}

function addGoToShipper(endpoint) {
    fetch(endpoint, {
        method: "put",
        headers: {
            'Content-type': 'application/json'
        },
    }).then(function (res) {
        console.log(res.status)
        if (res.status === 202)
            location.reload();
    }).catch(function (err) {
        console.error(err);
    });
}

function delShipper(endpoint) {
    fetch(endpoint, {
        method: "put",
        headers: {
            'Content-type': 'application/json'
        },
    }).then(function (res) {
        console.log(res.status)
        if (res.status === 202)
            location.reload();
    }).catch(function (err) {
        console.error(err);
    });
}





