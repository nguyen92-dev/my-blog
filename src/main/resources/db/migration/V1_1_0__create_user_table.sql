CREATE TABLE IF NOT EXISTS author (
    uuid UUID PRIMARY KEY,
    created_date TIMESTAMPTZ,
    last_modified_date TIMESTAMPTZ DEFAULT NOW(),
    user_name VARCHAR(255) UNIQUE NOT NULL,
    full_name VARCHAR(255) NOT NULL,
    dob DATE
)