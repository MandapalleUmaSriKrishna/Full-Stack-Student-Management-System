# StudentHub

A full-stack student management system built with Java, Spring Boot, MySQL, and React. It provides authenticated, role-aware student records in a focused administrative dashboard.

## Features

- Session-based authentication with seeded `ADMIN` and `STAFF` roles
- Student directory with indexed search, status filters, GPA summaries, and responsive layout
- Live student directory refresh every five seconds while the dashboard is open
- Admin-only student creation and deletion API permissions
- MySQL schema with indexes on status and department; H2 is used automatically for local development
- REST API under `/api/auth` and `/api/students`

## Run locally

Run these from the repository root in two separate terminals. Java 21+, Maven, and Node 20+ are required.

1. Start the API:

	```bash
	cd backend
	mvn spring-boot:run
	```

2. In a second terminal, start the React client:

	```bash
	cd /workspaces/Full-Stack-Student-Management-System/frontend
	npm install
	npm run dev
	```

3. Open `http://localhost:5173`. Demo accounts are `admin@campus.edu` / `admin123` and `staff@campus.edu` / `staff123`.

To use MySQL instead of the H2 fallback, set `DB_URL=jdbc:mysql://localhost:3306/studenthub`, `DB_USER`, and `DB_PASSWORD`, or run `docker compose up -d mysql` and use the credentials in `docker-compose.yml`.
