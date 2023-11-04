
    // Get a reference to the grid container where we will insert the grid items
    const gridContainer = document.querySelector(".grid-container");

    // Define the number of rows and columns for your grid
    const numRows = 5;
    const numCols = 5;

    // Loop to create and append grid items
    for (let i = 0; i < numRows; i++) {
        const row = document.createElement("div");
        row.className = "row justify-content-around";
        for (let j = 0; j < numCols; j++) {
            const gridItem = document.createElement("div");
            gridItem.className = "grid-item col-2"; // Adjust the class as needed
            gridItem.innerHTML = `
                <a href="intro-comic.html">
                <div class="caption">
                    <img src="Resource/img/images/001.jpg" alt="">
                    <div class="caption-content">
                        <h3>Caption ${i * numCols + j + 1}</h3>
                        <p>This is the caption for image ${i * numCols + j + 1}.</p>
                    </div>
                </div>
            `;
            row.appendChild(gridItem);
        }
        gridContainer.appendChild(row);
    }
