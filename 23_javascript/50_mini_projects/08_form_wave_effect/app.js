
const labels = document.querySelectorAll('.form-control label');


labels.forEach(label => {

  label.innerHTML = label.innerText
    .split('')
    .map((letter, indx) => `<span style="transition-delay:${indx * 30}ms">${letter}</span>`)
    .join('')
});


