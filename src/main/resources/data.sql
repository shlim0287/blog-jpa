CREATE TABLE  IF NOT EXISTS article(
                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         title VARCHAR(255) NOT NULL,
                         content VARCHAR(255) NOT NULL,
                         created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                         updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS comment(
    id BIGINT AUTO_INCREMENT PRIMARY KEY ,
    article_id BIGINT NOT NULL,
    body VARCHAR(255) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP()
);

--
-- INSERT INTO article (title, content, created_at, updated_at) VALUES ('제목1', '내용1', NOW(), NOW());
-- INSERT INTO article (title, content, created_at, updated_at) VALUES ('제목2', '내용2', NOW(), NOW());
-- INSERT INTO article (title, content, created_at, updated_at) VALUES ('제목3', '내용3', NOW(), NOW());
-- INSERT INTO article (title, content, created_at, updated_at) VALUES ('제목4', '내용4', NOW(), NOW());
-- INSERT INTO article (title, content, created_at, updated_at) VALUES ('제목5', '내용5', NOW(), NOW());
--
-- INSERT INTO comment (article_id, body, created_at) VALUES (1, '제목1에 대한 댓글1', NOW());
-- INSERT INTO comment (article_id, body, created_at) VALUES (1, '제목1에 대한 댓글2', NOW());
-- INSERT INTO comment (article_id, body, created_at) VALUES (1, '제목1에 대한 댓글3', NOW());
--
-- INSERT INTO comment (article_id, body, created_at) VALUES (2, '제목2에 대한 댓글1', NOW());
-- INSERT INTO comment (article_id, body, created_at) VALUES (2, '제목2에 대한 댓글2', NOW());
--
-- INSERT INTO comment (article_id, body, created_at) VALUES (3, '제목3에 대한 댓글1', NOW());
-- INSERT INTO comment (article_id, body, created_at) VALUES (3, '제목3에 대한 댓글2', NOW());
-- INSERT INTO comment (article_id, body, created_at) VALUES (3, '제목3에 대한 댓글3', NOW());
--
-- INSERT INTO comment (article_id, body, created_at) VALUES (4, '제목4에 대한 댓글1', NOW());
--
-- INSERT INTO comment (article_id, body, created_at) VALUES (5, '제목5에 대한 댓글1', NOW());
-- INSERT INTO comment (article_id, body, created_at) VALUES (5, '제목5에 대한 댓글2', NOW());
-- CREATE TABLE IF NOT EXISTS article(
--                                       id BIGSERIAL PRIMARY KEY,
--                                       title VARCHAR(255) NOT NULL,
--                                       content VARCHAR(255) NOT NULL,
--                                       created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
--                                       updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
-- );
--
-- CREATE TABLE IF NOT EXISTS comment(
--                                       id BIGSERIAL PRIMARY KEY,
--                                       article_id BIGINT NOT NULL,
--                                       body VARCHAR(255) NOT NULL,
--                                       created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
-- );
--
-- INSERT INTO article (title, content) VALUES ('제목1', '내용1');
-- INSERT INTO article (title, content) VALUES ('제목2', '내용2');
-- INSERT INTO article (title, content) VALUES ('제목3', '내용3');
-- INSERT INTO article (title, content) VALUES ('제목4', '내용4');
-- INSERT INTO article (title, content) VALUES ('제목5', '내용5');
--
-- INSERT INTO comment (article_id, body, created_at) VALUES (1, '제목1에 대한 댓글1', CURRENT_TIMESTAMP);
-- INSERT INTO comment (article_id, body, created_at) VALUES (1, '제목1에 대한 댓글2', CURRENT_TIMESTAMP);
-- INSERT INTO comment (article_id, body, created_at) VALUES (1, '제목1에 대한 댓글3', CURRENT_TIMESTAMP);
--
-- INSERT INTO comment (article_id, body, created_at) VALUES (2, '제목2에 대한 댓글1', CURRENT_TIMESTAMP);
-- INSERT INTO comment (article_id, body, created_at) VALUES (2, '제목2에 대한 댓글2', CURRENT_TIMESTAMP);
--
-- INSERT INTO comment (article_id, body, created_at) VALUES (3, '제목3에 대한 댓글1', CURRENT_TIMESTAMP);
-- INSERT INTO comment (article_id, body, created_at) VALUES (3, '제목3에 대한 댓글2', CURRENT_TIMESTAMP);
-- INSERT INTO comment (article_id, body, created_at) VALUES (3, '제목3에 대한 댓글3', CURRENT_TIMESTAMP);
--
-- INSERT INTO comment (article_id, body, created_at) VALUES (4, '제목4에 대한 댓글1', CURRENT_TIMESTAMP);
--
-- INSERT INTO comment (article_id, body, created_at) VALUES (5, '제목5에 대한 댓글1', CURRENT_TIMESTAMP);
-- INSERT INTO comment (article_id, body, created_at) VALUES (5, '제목5에 대한 댓글2', CURRENT_TIMESTAMP);
