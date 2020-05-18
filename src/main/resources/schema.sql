CREATE TABLE `instructor` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(50) DEFAULT NULL,
    `last_name` VARCHAR(50) DEFAULT NULL,
    `email` VARCHAR(50) DEFAULT NULL,
    PRIMARY KEY (`id`)
);


CREATE TABLE `instructor_detail` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `youtube_channel` VARCHAR(128) DEFAULT NULL,
    `hobby` VARCHAR(50) DEFAULT NULL,
    `instructor_id` INT NOT NULL,
    PRIMARY KEY (`id`),
    FOREIGN KEY (`instructor_id`) REFERENCES `instructor`(`id`)
);

