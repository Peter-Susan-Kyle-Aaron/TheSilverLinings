Use silver_lining_db;

Drop TABLE if exists posts_workers;
Drop TABLE if exists reviews;
Drop TABLE if exists posts;
Drop TABLE if exists users;

# Users

# Select * from Users;

insert into Users (username, password, email, address, photo, role)
values ('Brad Bernard','$2a$10$Np9uN3PKPI10iYO1Yv.de.vHgWaJ/VunlS.uAV9eD0d7A044Uj8V2','BradlyBernard@aol.com','611 Enchanted Way','https://cdn.filestackcontent.com/rOyA2SLvR4uARIjYhCue',1),
('Linda Turner', '$2a$10$jr5fSUJ.tSwTADEWIxAgWeGFuV1J8pr52JkUin1hOFRaOLf5WTGi6', 'susan.lin0705@gmail.com', '12222 Bianca Mill Way', 'https://cdn.filestackcontent.com/ILcai4UBRVGJV4AcPHb1', 2),
('Harold Bucke', 'J8B0JYH4zaB8', 'mbucke3@ning.com', '3 Portage Pass', 'https://cdn.filestackcontent.com/9GnznZ8yQW2p48andyNX', 2),
('Maryellen de Guerre', 'TwQOBcsf', 'mde4@ucsd.edu', '8 Stoughton Court', 'https://cdn.filestackcontent.com/0Hu0yoJEQ06mWrYiS90X', 2),
('Glori Hastwell', 'I7eeHKH7OIN', 'ghastwell5@utexas.edu', '62855 Anthes Hill', 'https://cdn.filestackcontent.com/Aa9mAkuqRuaMtiWDca91', 2),
('Early Brewood', 'PrZrmz', 'ebrewood6@washington.edu', '64 Chive Hill', 'https://cdn.filestackcontent.com/ZHWO3n6oReSiPx4VBz3t', 2),
('Harwilll Worgan', 'rZEVpfvwBO7', 'hworgan7@wsj.com', '1852 Eggendart Circle', 'https://cdn.filestackcontent.com/EmwZ8IsNR3rOeflFiDIg', 2),
('Brear Chaffin', '481qCxV', 'bchaffin8@vkontakte.ru', '33 Shasta Way', 'https://cdn.filestackcontent.com/2W7bl1CKQdS9cgvrx6GT', 2),
('Evelyn Murney', 'QYe08m3z85f', 'emurney9@youtu.be', '365 Helena Hill', 'https://cdn.filestackcontent.com/qf13kNi7SJGcECzhLYmf', 2);


#Posts

insert into Posts (body, user_id, Category, Location,is_complete,title, date)
values

       ('I need my groceries delivered',3,'Delivery','100 Military Plaza',false,'Grab my groceries','2019-10-24 14:00'),
       ('I need the lightbulb changed and I can\'t reach it', 6,'Assistance','1607 E Houston Street',false,'Help me change a lightbulb','2019-11-21 14:00'),
       ('Need someone to deliver a card to my grandson',2,'Delivery','3000 Pennsylvania Avenue',false,'Delivery to my grandson','2019-10-18 14:00'),
       ('I need help weeding my flowers',7,'Delivery','',false,'Help around the yard','2019-10-15 14:00'),
       ('I need my dogs walked',5,'Assistance','',false,'Dogs need to be walked','2019-10-16 17:00'),
       ('I need my dogs walked',4,'Assistance','',false,'Dogs need to be walked','2019-10-23 17:00'),
       ('Need my trash taken out',8,'Assistance','',false,'Trash taken to street','2019-11-15 19:30'),
       ('Need my food deliverd from Outback Steakhouse, under name of GLori',9,'Delivery','',false,'Food Delivered','2019-10-10 12:30');

#Reviews
insert into Reviews (description, rating, reviewer_id, user_id)
values ('Really nice young man',5,7,1),
       ('Arrived 30 minutes late both times I needed my dogs walked',2,3,1),
       ('Very Helpful',5,7,1),
       ('Delivered my groceries despite the rain',5,7,1),
       ('Unloaded and helped me put away my groceries',5,7,1);
