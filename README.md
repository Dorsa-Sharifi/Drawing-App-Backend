# 🎨 Drawing App

A simple **React + Spring Boot** web application for drag-and-drop drawing with basic shapes.  
Users can **import/export** their drawings as JSON files and view **real-time shape statistics**.  
Each user can save **one painting** on the backend, which persists between sessions.

---

## 🚀 Features

### 🧠 Frontend (React)
- **Editable Painting Name** – Rename your drawing directly in the header.  
- **Import / Export** – Save and load drawings (including metadata) as `.json` files.  
- **Sidebar** – Drag shapes (**circle**, **square**, **triangle**) from the left sidebar.  
- **Canvas** – Drop shapes on the central canvas and freely position them.  
- **Shape Removal** – Double-click a shape to remove it from the canvas.  
- **Shape Counter** – Bottom bar displays shape types and counts in real time.

### ⚙️ Backend (Spring Boot)
- Each user can **store one painting** at a time (saving again overwrites the previous one).  
- Supports **user management**, **painting persistence**, and **data retrieval**.  
- Fully integrated with a **relational database** (e.g., H2 or PostgreSQL).

---

## 🧩 Component Overview

### `App.tsx`
All components, functions, and handlers used in `App.tsx` are summarized below.

#### **State Management**
- `paintingName`: Title of the drawing.  
- `shapes`: Array of placed shapes.  
- `draggingShape`: Tracks the shape type currently being dragged.

#### **Handlers**
- `addShape()`: Adds a shape to the canvas.  
- `handleDrop()`: Calculates the drop position and adds the shape.  
- `handleExport()`: Saves the drawing as a JSON file.  
- `handleImport()`: Loads a drawing from a JSON file.  
- `removeShape()`: Deletes a shape when double-clicked.

### `ShapeIcon`
A helper component that renders small shape previews (`circle`, `square`, `triangle`).

---

## 💾 JSON Structure (Import / Export)

Example of how a drawing is stored:

```json
{
  "name": "My Painting",
  "shapes": [
    {
      "id": "uuid",
      "type": "circle",
      "x": 100,
      "y": 150
    }
  ]
}
```

---

# 🖥️ Backend Overview

### 👤 User
Defines the **User** entity with:
- unique **ID** (primary key)
- **username** (used for storage)
- **display name** (shown in the UI)

### 🖼️ Painting
Each **Painting** entity stores:
- name  
- ID  
- creator (user)  
- shape coordinates  
- creation timestamp  

### 🗂️ Repository
Contains:
- `UserRepository`  
- `PaintingRepository`  

Used for querying and retrieving data from the database.

### 🎨 PaintingController
Implements the rule that **each user can store only one painting**.  
If a user saves a new one, the old painting is deleted.  
All painting metadata is stored and retrievable by user ID or painting ID.

### 👥 UserController
Handles user-related requests and returns the list of all registered users.

---

# ⚡ Setup Instructions

## 🧠 Frontend (React)
### Prerequisites
- Node.js ≥ 18  
- npm or yarn

### Run Locally
```bash
cd frontend
npm install
npm run dev
```
Then open [http://localhost:5173](http://localhost:5173) in your browser.

---

## ⚙️ Backend (Spring Boot)
### Prerequisites
- Java 17+  
- Maven or Gradle  

### Run Locally
```bash
cd backend
./mvnw spring-boot:run
```
By default, the backend runs at [http://localhost:8080](http://localhost:8080).

You can configure database connection and server settings in  
`src/main/resources/application.properties`.

---

# 👩‍💻 Authors
- Dorsa Sharifi Ghombavani – Frontend & Backend Developer 

---

# 📜 License
[![React](https://img.shields.io/badge/frontend-React-61dafb?logo=react&logoColor=white)](https://react.dev/)
[![Backend](https://img.shields.io/badge/backend-Spring%20Boot-6db33f?logo=springboot&logoColor=white)](https://spring.io/projects/spring-boot)
[![License](https://img.shields.io/badge/license-MIT-green)](LICENSE)

