Use silver_lining_db;

Drop TABLE if exists reviews;
Drop TABLE if exists posts;
Drop TABLE if exists users;

# Users

insert into Users (username, password, email, address, photo, role)
values ('kyle','$2a$10$Np9uN3PKPI10iYO1Yv.de.vHgWaJ/VunlS.uAV9eD0d7A044Uj8V2','kyle@mail.com','1234 Nowhereville','',1),
('Bev Ivan', 'EWqlqmgPB0', 'bivan0@last.fm', '16 Granby Way', 'https://robohash.org/sintbeataeid.png?size=50x50&set=set1', 2),
('Sebastien Devereux', 'JKwYFR', 'sdevereux1@blogger.com', '8 Laurel Hill', 'https://robohash.org/dolorumrepellendusut.jpg?size=50x50&set=set1', 2),
('Kristen Dyett', '1k8pa5Y5UWDp', 'kdyett2@slideshare.net', '71039 Cody Street', 'https://robohash.org/natusquiesse.bmp?size=50x50&set=set1', 1),
('Mace Bucke', 'J8B0JYH4zaB8', 'mbucke3@ning.com', '3 Portage Pass', 'https://robohash.org/nullaquiavel.bmp?size=50x50&set=set1', 2),
('Maryellen de Guerre', 'TwQOBcsf', 'mde4@ucsd.edu', '8 Stoughton Court', 'https://robohash.org/culpasequiet.png?size=50x50&set=set1', 2),
('Glori Hastwell', 'I7eeHKH7OIN', 'ghastwell5@utexas.edu', '62855 Anthes Hill', 'https://robohash.org/magnamnamet.png?size=50x50&set=set1', 2),
('Early Brewood', 'PrZrmz', 'ebrewood6@washington.edu', '64 Chive Hill', 'https://robohash.org/nobisteneturporro.bmp?size=50x50&set=set1', 1),
('Harwilll Worgan', 'rZEVpfvwBO7', 'hworgan7@wsj.com', '1852 Eggendart Circle', 'https://robohash.org/ametquieum.bmp?size=50x50&set=set1', 1),
('Brear Chaffin', '481qCxV', 'bchaffin8@vkontakte.ru', '33 Shasta Way', 'https://robohash.org/repellatdoloribusvelit.png?size=50x50&set=set1', 2),
('Evelyn Murney', 'QYe08m3z85f', 'emurney9@youtu.be', '365 Helena Hill', 'https://robohash.org/sequiaperiamculpa.png?size=50x50&set=set1', 1);


#Posts
insert into Posts (Title, Description, user_id, Category, Event_Location)
values ('sit', 'Integer pede justo, lacinia eget, tincidunt eget, tempus vel, pede. Morbi porttitor lorem id ligula. Suspendisse ornare consequat lectus. In est risus, auctor sed, tristique in, tempus sit amet, sem.', 5, 'Drama', '69 Lakewood Gardens Junction'),
('sed magna at nunc commodo', 'Nulla tempus.', 1, 'Animation|Sci-Fi', '3417 Nova Road'),
('tincidunt eu', 'Fusce congue, diam id ornare imperdiet, sapien urna pretium nisl, ut volutpat sapien arcu sed augue. Aliquam erat volutpat. In congue.', 10, 'Comedy|Musical|Romance', '776 Lillian Point'),
('diam id ornare imperdiet', 'Duis mattis egestas metus. Aenean fermentum. Donec ut mauris eget massa tempor convallis. Nulla neque libero, convallis eget, eleifend luctus, ultricies eu, nibh.', 10, 'Drama|Romance', '45 Springs Avenue'),
('platea dictumst', 'Aenean auctor gravida sem. Praesent id massa id nisl venenatis lacinia. Aenean sit amet justo. Morbi ut odio.', 8, 'Horror|Sci-Fi', '888 Golf View Way');

#Reviews

