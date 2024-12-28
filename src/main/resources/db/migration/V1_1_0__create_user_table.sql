CREATE TABLE IF NOT EXISTS author (
    uuid UUID PRIMARY KEY,
    created_date TIMESTAMP,
    last_modified_date TIMESTAMP,
    user_name VARCHAR(255) UNIQUE NOT NULL,
    full_name VARCHAR(255) NOT NULL,
    dob DATE
)