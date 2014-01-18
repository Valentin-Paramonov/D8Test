function confirmDelete(form, user, action) {
    if (confirm('Delete user ' + user + '?')) {
        form.action = action;
        return true;
    }

    return false;
}
