insert into usuario(name,email,password)
values('eduardo','ed@gmail.com','$2a$10$qKZPTcTrG6zKdMojzc19FO0OwMudtajIWn41MRgL7OfretcR1dL46');
insert into module(name) values("proyect") ,("proyect_user") ,("sprint") ,("documentation") ,("user") ,("user_story")
                               ,("feature") ,("epic") ,("state");
insert into operation(name) values ("create","read","update","delete");

insert into permission(module_id,operation_id) values (1,1),(1,2),(1,3),(1,4),
                                                      (2,1),(2,2),(2,3),(2,4),
                                                      (3,1),(3,2),(3,3),(3,4),
                                                      (4,1),(4,2),(4,3),(4,4),
                                                      (5,1),(5,2),(5,3),(5,4),
                                                      (6,1),(6,2),(6,3),(6,4),
                                                      (7,1),(7,2),(7,3),(7,4),
                                                      (8,1),(8,2),(8,3),(8,4),
                                                      (9,1),(9,2),(9,3),(9,4);
insert into rol(name,description) values ("admin","All permissions"),
                                         ("collaborator","Any permissions"),
                                         ("basic","View permissions");

insert rol_permission(rol_id,module_id,operation_id) values (1,1,1),(1,1,2),(1,1,3),(1,1,4),
                                                            (1,2,1),(1,2,2),(1,2,3),(1,2,4),
                                                            (1,3,1),(1,3,2),(1,3,3),(1,3,4),
                                                            (1,4,1),(1,4,2),(1,4,3),(1,4,4),
                                                            (1,5,1),(1,5,2),(1,5,3),(1,5,4),
                                                            (1,6,1),(1,6,2),(1,6,3),(1,6,4),
                                                            (1,7,1),(1,7,2),(1,7,3),(1,7,4),
                                                            (1,8,1),(1,8,2),(1,8,3),(1,8,4),
                                                            (1,9,1),(1,9,2),(1,9,3),(1,9,4),

                                                            (2,2,2),(2,3,2),(2,4,2),(2,9,2)
                                                            (2,5,1),(2,5,2),(2,5,3),(2,5,4),
                                                            (2,6,1),(2,6,2),(2,6,3),(2,6,4),
                                                            (2,7,1),(2,7,2),(2,7,3),(2,7,4),
                                                            (2,8,1),(2,8,2),(2,8,3),(2,8,4),

                                                            (3,2,2),(3,3,2),(3,4,2),(3,9,2)
                                                            (3,5,2),(3,6,2),(3,7,2),(3,8,2);

