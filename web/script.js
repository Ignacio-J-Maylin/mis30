function loadImages(folderPath) {
    fetch(`${folderPath}/image-list.json`)
        .then(response => response.json())
        .then(imageData => {
            const collageItems = [];
            const collageContainer = document.getElementById('collage-container');

            for (const imageUrl of imageData) {
                const collageItem = document.createElement('div');
                collageItem.classList.add('collage-item');
                collageItem.style.backgroundImage = `url(${imageUrl})`;

                collageItems.push(collageItem);
                collageContainer.appendChild(collageItem);
            }

            arrangeCollageItems();
        })
        .catch(error => {
            console.error(`Error loading image data: ${error}`);
        });
}

// ... (rest of the arrangeCollageItems function remains the same)
