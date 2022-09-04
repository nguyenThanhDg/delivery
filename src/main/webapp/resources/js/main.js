function addComment(endpoint, shipperId) {
    fetch(endpoint, {
        method: 'post',
        body: JSON.stringify({
            "content": document.getElementById("commentId").value,
            "shipperId": shipperId
        }),
        headers: {
            "Content-Type": "application/json"
        }
    }).then(function(res) {
        
        return res.json()
    }).then(function(data) {
       console.log('Success:', data);
    })
    location.reload()
}

function addRating(endpoint, shipperId) {
    var selectedSize
    const radioButtons = document.querySelectorAll('input[name="myrating"]')
    for (const radioButton of radioButtons) {
        if (radioButton.checked) {
            selectedSize = radioButton.value;
        }
    }
    fetch(endpoint, {
        method: 'post',
        body: JSON.stringify({
            "rate": selectedSize,
            "shipperId": shipperId
        }),
        headers: {
            "Content-Type": "application/json"
        }
    }).then(function(res) {
        
        return res.json()
    }).then(function(data) {
       console.log('Success:', data);
    })
    location.reload()
}

function addProductShip(endpoint, productId) {
    fetch(endpoint, {
        method: 'post',
        body: JSON.stringify({
            "content": document.getElementById("costId").value,
            "productId": productId
        }),
        headers: {
            "Content-Type": "application/json"
        }
    }).then(function(res) {
        
        return res.json()
    }).then(function(data) {
       console.log('Success:', data);
    })
    location.reload()
}



