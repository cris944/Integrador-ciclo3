document.getElementById('toggle-btn').addEventListener('click', function() {
    document.getElementById('sidebar').classList.toggle('collapsed');
    document.getElementById('main-content').classList.toggle('collapsed');
});

function loadStudents() {
    const studentsTable = document.getElementById('students-table').getElementsByTagName('tbody')[0];
    const students = JSON.parse(localStorage.getItem('students')) || [];
    students.forEach(student => {
        const newRow = studentsTable.insertRow();
        student.forEach((value, index) => {
            const cell = newRow.insertCell(index);
            cell.innerText = value;
        });
        const actionsCell = newRow.insertCell(student.length);
        actionsCell.innerHTML = `<button class="edit-btn" onclick="editRow(this, 'students-table', 'students')">Editar</button> <button class="delete-btn" onclick="deleteRow(this, 'students-table', 'students')">Eliminar</button>`;
    });
}

function loadCareers() {
    const careerTable = document.getElementById('career-table').getElementsByTagName('tbody')[0];
    const careers = JSON.parse(localStorage.getItem('careers')) || [];
    careers.forEach(career => {
        const newRow = careerTable.insertRow();
        career.forEach((value, index) => {
            const cell = newRow.insertCell(index);
            cell.innerText = value;
        });
        const actionsCell = newRow.insertCell(career.length);
        actionsCell.innerHTML = `<button class="edit-btn" onclick="editRow(this, 'career-table', 'careers')">Editar</button> <button class="delete-btn" onclick="deleteRow(this, 'career-table', 'careers')">Eliminar</button>`;
    });
}

function saveToLocalStorage(tableId, key) {
    const table = document.getElementById(tableId).getElementsByTagName('tbody')[0];
    const data = Array.from(table.rows).map(row => {
        return Array.from(row.cells).slice(0, -1).map(cell => cell.innerText);
    });
    localStorage.setItem(key, JSON.stringify(data));
}

function addRow() {
    const table = document.getElementById('students-table').getElementsByTagName('tbody')[0];
    const newRow = table.insertRow();
    
    const cell1 = newRow.insertCell(0);
    const cell2 = newRow.insertCell(1);
    const cell3 = newRow.insertCell(2);
    const cell4 = newRow.insertCell(3);
    const cell5 = newRow.insertCell(4);
    const cell6 = newRow.insertCell(5);
    const cell7 = newRow.insertCell(6);
    const cell8 = newRow.insertCell(7);
    const cell9 = newRow.insertCell(8);
    
    cell1.innerHTML = `<input type="text" placeholder="Nombre">`;
    cell2.innerHTML = `<input type="text" placeholder="Apellido">`;
    cell3.innerHTML = `<input type="text" placeholder="DNI">`;
    cell4.innerHTML = `<input type="text" placeholder="Carrera">`;
    cell5.innerHTML = `<input type="text" placeholder="Ciclo">`;
    cell6.innerHTML = `<input type="text" placeholder="Código">`;
    cell7.innerHTML = `<input type="text" placeholder="Correo">`;
    cell8.innerHTML = `<input type="text" placeholder="Teléfono">`;
    cell9.innerHTML = `<button class="save-btn" onclick="saveRow(this, 'students-table', 'students')">Guardar</button> <button class="delete-btn" onclick="deleteRow(this, 'students-table', 'students')">Eliminar</button>`;
}

function addCareerRow() {
    const table = document.getElementById('career-table').getElementsByTagName('tbody')[0];
    const newRow = table.insertRow();
    
    const cell1 = newRow.insertCell(0);
    const cell2 = newRow.insertCell(1);
    const cell3 = newRow.insertCell(2);
    
    cell1.innerHTML = `<input type="text" placeholder="Nombre de la Carrera">`;
    cell2.innerHTML = `<input type="text" placeholder="Director de Carrera">`;
    cell3.innerHTML = `<button class="save-btn" onclick="saveRow(this, 'career-table', 'careers')">Guardar</button> <button class="delete-btn" onclick="deleteRow(this, 'career-table', 'careers')">Eliminar</button>`;
}

function saveRow(button, tableId, storageKey) {
    const row = button.parentNode.parentNode;
    const inputs = row.getElementsByTagName('input');
    const values = Array.from(inputs).map(input => input.value || 'N/A');

    for (let i = 0; i < values.length; i++) {
        row.cells[i].innerText = values[i];
    }
    row.cells[values.length].innerHTML = `<button class="edit-btn" onclick="editRow(this, '${tableId}', '${storageKey}')">Editar</button> <button class="delete-btn" onclick="deleteRow(this, '${tableId}', '${storageKey}')">Eliminar</button>`;
    saveToLocalStorage(tableId, storageKey);
}

function editRow(button, tableId, storageKey) {
    const row = button.parentNode.parentNode;
    const values = Array.from(row.cells).slice(0, -1).map(cell => cell.innerText);

    for (let i = 0; i < values.length; i++) {
        row.cells[i].innerHTML = `<input type="text" value="${values[i]}">`;
    }
    row.cells[values.length].innerHTML = `<button class="save-btn" onclick="saveRow(this, '${tableId}', '${storageKey}')">Guardar</button> <button class="delete-btn" onclick="deleteRow(this, '${tableId}', '${storageKey}')">Eliminar</button>`;
}

function deleteRow(button, tableId, storageKey) {
    const row = button.parentNode.parentNode;
    row.parentNode.removeChild(row);
    saveToLocalStorage(tableId, storageKey);
}
