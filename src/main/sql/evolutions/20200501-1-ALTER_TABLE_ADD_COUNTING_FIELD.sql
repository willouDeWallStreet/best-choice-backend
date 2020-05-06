ALTER TABLE answer ADD counting NUMERIC(9,0) DEFAULT 0;

ALTER TABLE ONLY answer ALTER COLUMN counting SET NOT NULL;
ALTER TABLE ONLY answer ADD CONSTRAINT positive_counting CHECK (counting >= 0);