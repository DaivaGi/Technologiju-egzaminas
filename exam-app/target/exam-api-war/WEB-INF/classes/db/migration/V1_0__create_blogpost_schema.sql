CREATE TABLE BLOG_POST (
	ID BIGINT GENERATED BY DEFAULT AS IDENTITY,
    CREATED_DATE TIMESTAMP,
	TITLE CHARACTER VARYING(100),
    TEXT CHARACTER VARYING(255),
    COMMENT_ID BIGINT,

	CONSTRAINT BLOG_POST_PK PRIMARY KEY (ID)
)