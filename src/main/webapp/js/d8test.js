function confirmDelete(form, info, action) {
    if (confirm('Delete ' + info + '?')) {
        form.action = action;
        return true;
    }

    return false;
}

function submitForm(form, action) {
    form.action = action;
    form.submit();
}
