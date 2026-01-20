```markdown
# Expense Manager API

Full-featured Expense Manager backend implemented in Java 17 and Spring Boot. Features:
- Multi-tenant organization support
- JWT authentication and RBAC (USER, MANAGER, ADMIN)
- Expense CRUD + submit/approve/reject workflow
- CSV import for expenses (placeholder / synchronous)
- Monthly reports (CSV placeholder)
- Email + webhook notifications on approvals (configurable)
- Audit logs
- Flyway migrations
- Docker + docker-compose
- Integration tests with Testcontainers

Quickstart (local)
1. Create a new Git repository locally and add these files, or copy these files into your GitHub repo `Saiprasadpatro/expense-manager`.
2. Build with Maven:
   - mvn -B package
   - (Or use `./mvnw` if you add the wrapper.)
3. Run with Docker Compose:
   - docker compose up --build
   - The app will be available at http://localhost:8080
4. API:
   - POST /api/auth/register
   - POST /api/auth/login -> { "token": "..." }
   - Use Authorization: Bearer <token> for protected endpoints

Environment
- Configure SMTP via environment variables if you want email notifications:
  - MAIL_HOST, MAIL_PORT, MAIL_USERNAME, MAIL_PASSWORD
- Set JWT secret via APP_JWT_SECRET (docker-compose sets a placeholder)

Notes & next improvements
- The CSV import and monthly report endpoints are simple placeholders; for large files you should implement streaming/async processing.
- The AuthFilter is included but ensure the JWT secret is strong and stored in environment manager (not in repo).
- Consider adding Postgres Row-Level Security (RLS) if you need stronger tenant separation.
- Add more comprehensive tests and CI steps for integration tests with Testcontainers.

If you want, I can:
- Push these files to your GitHub repository (you'll need to invite me or provide a temporary token) — or I can give you a step-by-step push guide.
- Expand CSV import, implement receipt attachments (MinIO/S3), or add full role enforcement for approvals.

```
