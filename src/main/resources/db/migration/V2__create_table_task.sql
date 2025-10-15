CREATE TABLE task (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description TEXT,
    status VARCHAR(50) NOT NULL,
    priority VARCHAR(50) NOT NULL,
    due_date DATE,
    project_id BIGINT,
    CONSTRAINT fk_task_project FOREIGN KEY (project_id)
        REFERENCES project (id)
        ON DELETE CASCADE

);