# Backend Microservices Assessment | Roll No: 2305110100140

My complete solution for the backend practical evaluation, consisting of two independent, native Java microservices.

## 📁 Project Layout
* **`question-1/`** - Vehicle Maintenance Scheduler (`Port 8081`)
  * `/depots` & `/vehicles` endpoints returning core capacity metrics.
* **`question-2/`** - Campus Notifications Microservice (`Port 8082`)
  * `/notifications` endpoint distributing sorted, prioritized alerts (`Placement > Result > Event`).

## 🛠️ Tech Stack & Features
* **Native Java HTTP Server** - Built without external framework overhead.
* **Concurrency** - Configured with a `CachedThreadPool` executor context to support parallel requests.
* **Schema Matching** - Structured to output the exact JSON key tokens required by the assignment guidelines.

## 🚀 Compilation & Run

### Service 1:
```bash
cd question-1/src
javac com/affordmed/scheduler/*.java
java com.affordmed.scheduler.MaintenanceApplication
