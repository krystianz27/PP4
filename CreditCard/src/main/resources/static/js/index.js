getProducts = () => {
    return fetch("/api/products")
        .then(r => r.json())
        .catch((error) => console.log(error))
};

createProductHtmlEl = (productData) => {
const template = `
    <div>
        <img src ="https://picsum.photos/200/300" width=200 height=200  alt=""/>
        <h4>${productData.name}</h4>
        <span>${productData.description}</span>
        <span>${productData.price}</span>
        <button data-id="${productData.id}">Add to cart</button>
    </div>
    `;
    const newEl = document.createElement("div");
    newEl.innerHTML = template;
    return newEl
};

document.addEventListener("DOMContentLoaded", () => {
//    console.log("it works");
    const productsList = document.querySelector("#productsList");
    getProducts()
        .then(products => products.map(createProductHtmlEl))
        .then(productsHtmls => {
            productsHtmls.forEach(htmlEl => productsList.appendChild(htmlEl) )
})

});