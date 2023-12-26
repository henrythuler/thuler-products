const menu = document.querySelector(".menu");
document.querySelector(".button-menu").addEventListener("click", (e) => {
    menu.style.marginLeft = "0"
})

document.querySelector(".close-menu").addEventListener("click", (e) => {
    menu.style.marginLeft = "-500px"
})