# Task Checklist – IT342 Lab 1 (Session 1)

**Repository:** IT342_G5_<Lastname>_Lab1

---

## DONE

| Task | Description | Commit Hash |
|------|-------------|-------------|
| Backend – Project setup | Spring Boot, MySQL, JPA, Security, JWT | *(add after first commit)* |
| Backend – POST /api/auth/register | User registration with validation | *(add after commit)* |
| Backend – POST /api/auth/login | Login returns JWT | *(add after commit)* |
| Backend – GET /api/user/me | Protected current user profile | *(add after commit)* |
| Backend – Database | MySQL connection, User entity, repository | *(add after commit)* |
| Backend – Password encryption | BCrypt via Spring Security | *(add after commit)* |
| Web – Register page | Form and API integration | *(add after commit)* |
| Web – Login page | Form and API integration | *(add after commit)* |
| Web – Dashboard/Profile page | Protected, shows user info | *(add after commit)* |
| Web – Logout | Logout button and clear token | *(add after commit)* |
| Repo structure | /web, /backend, /mobile, /docs, README | *(add after commit)* |

**Instructions:** After each `git commit`, run `git log -1 --format="%h"` and paste the hash in the table above for the relevant task(s).

---

## IN-PROGRESS

| Task | Description |
|------|-------------|
| Documentation – FRS PDF | Add ERD, UML, Web UI screenshots to /docs and export PDF |
| TASK_CHECKLIST – Commit hashes | Fill commit hash column after pushing to GitHub |

---

## TODO

| Task | Description |
|------|-------------|
| Mobile app | Session 2 – not required for this submission |
| (Add any incomplete features here) | |

---

## Notes

- Passwords are never stored in plain text (BCrypt).
- Mobile app is not required in this submission.
- Replace `<Lastname>` in the repo name with your actual last name.
