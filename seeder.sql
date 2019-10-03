Use silver_lining_db;

# Drop TABLE if exists posts_workers;
# Drop TABLE if exists reviews;
# Drop TABLE if exists posts;
# Drop TABLE if exists users;

# Users

# Select * from Users;

insert into Users (username, password, email, address, photo, role)
values ('Kyle','$2a$10$Np9uN3PKPI10iYO1Yv.de.vHgWaJ/VunlS.uAV9eD0d7A044Uj8V2','kmaulsby15@gmail.com','611 Enchanted Way','https://cdn.filestackcontent.com/uNbV2WPGRaQjUtJnVHpQ',1),
('Susan Lin', '$2a$10$jr5fSUJ.tSwTADEWIxAgWeGFuV1J8pr52JkUin1hOFRaOLf5WTGi6', 'susan.lin0705@gmail.com', '12222 Bianca Mill Way', 'https://cdn.filestackcontent.com/EnaVwudxTxuQxQy3yNEi', 2),
('Mace Bucke', 'J8B0JYH4zaB8', 'mbucke3@ning.com', '3 Portage Pass', 'https://robohash.org/nullaquiavel.bmp?size=50x50&set=set1', 2),
('Maryellen de Guerre', 'TwQOBcsf', 'mde4@ucsd.edu', '8 Stoughton Court', 'https://robohash.org/culpasequiet.png?size=50x50&set=set1', 2),
('Glori Hastwell', 'I7eeHKH7OIN', 'ghastwell5@utexas.edu', '62855 Anthes Hill', 'https://robohash.org/magnamnamet.png?size=50x50&set=set1', 2),
('Early Brewood', 'PrZrmz', 'ebrewood6@washington.edu', '64 Chive Hill', 'https://robohash.org/nobisteneturporro.bmp?size=50x50&set=set1', 2),
('Harwilll Worgan', 'rZEVpfvwBO7', 'hworgan7@wsj.com', '1852 Eggendart Circle', 'https://robohash.org/ametquieum.bmp?size=50x50&set=set1', 2),
('Brear Chaffin', '481qCxV', 'bchaffin8@vkontakte.ru', '33 Shasta Way', 'https://robohash.org/repellatdoloribusvelit.png?size=50x50&set=set1', 2),
('Evelyn Murney', 'QYe08m3z85f', 'emurney9@youtu.be', '365 Helena Hill', 'https://robohash.org/sequiaperiamculpa.png?size=50x50&set=set1', 2);


#Posts

insert into Posts (body, user_id, Category, Location,is_complete,title, date)
values
       ('Make sure not to forget my cat food, the last person didn''t bring any',3,'Delivery','600 Navaro Street',false,'Delivery from HEB','2019-12-24 14:00'),
       ('I need my groceries delivered',3,'Delivery','600 Navaro Street',false,'Delivery from HEB','2019-10-24 14:00'),
       ('I need the lightbulb changed and I can\'t reach it', 6,'Delivery','600 Navaro Street',false,'Help me change a lightbult','2019-11-21 14:00'),
       ('Need someone to deliver a card to my grandson',5,'Delivery','600 Navaro Street',false,'Delivery to my grandson','2019-10-18 14:00'),
       ('I need help weeding my flowers',4,'Delivery','600 Navaro Street',false,'Help around the yard','2019-10-15 14:00');

#Reviews
insert into Reviews (description, rating, reviewer_id, user_id)
values ('Really nice young man',5,7,1),
       ('Arrived 30 minutes late both times I needed my dogs walked',2,3,1),
       ('Very Helpful',5,7,1),
       ('Delivered my groceries despite the rain',5,7,1),
       ('Unloaded and helped me put away my groceries',5,7,1);
