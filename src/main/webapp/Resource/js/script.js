const stars = document.querySelectorAll(".stars i");

stars.forEach((star, index1) => {
    star.addEventListener("click", () => {  
        stars.forEach((star, index2)=> {
             index1 >= index2 ? star.classList.add("active") : star.classList.remove("active"); 
        });
        const rating = index1 + 1;
        const xhr = new XMLHttpRequest();
        xhr.open("POST", "/ratings.jsp");
        xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        xhr.send("rating=" + rating);
    });
    
});