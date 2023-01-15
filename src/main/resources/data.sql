INSERT INTO
    address(street, city, state, postal_code, country)
VALUES
    ("Karkonowska 11"           , "Wroclaw"         , "Dolny Slask" , "12345", "Poland"),
    ("Zwycieska 12"             , "Wroclaw"         , "Dolny Slask" , "12346", "Poland"),
    ("Powstancow Slaskich 12"   , "Wroclaw"         , "Dolny Slask" , "12347", "Poland"),
    ("Aleje Jerozolimskie 157a" , "Warszawa"        , "Mazowieckie" , "54321", "Poland"),
    ("Krakowska 2"              , "Poznan"          , "Weilkopolska", "12385", "Poland"),
    ("Wielka 20/8"              , "Krakow"          , "Malopolska"  , "17345", "Poland"),
    ("Nyska 12"                 , "Bielsko Biala"   , "Slask"       , "12405", "Poland");

INSERT INTO
    personal_data(name, last_name, personal_id, passport_id, birth_date, fathers_name, mothers_name)
VALUES
    ("Marcin"   , "Kowal"       , "00210212345", "AA1234567", "2000-01-02"  , "Jan"         , "Beata"),
    ("Jan"      , "Kowal"       , "78292212345", "AA1234568", "1978-09-22"  , "Dawid"       , "Urszula"),
    ("Magda"    , "Nowak"       , "88252112345", "AA1234569", "1988-05-21"  , "Michal"      , "Anna"),
    ("Anna"     , "Szpak"       , "04261412345", "AA1234570", "2004-06-14"  , "Maciej"      , "Ala"),
    ("Konrad"   , "Szewc"       , "93250312345", "AA1234571", "1993-05-0"   , "Maksymilian" , "Kasia"),
    ("Agnieszka", "Wolc"        , "87220112345", "AA1234572", "1987-02-01"  , "Patryk"      , "Anna"),
    ("Anna"     , "Wesołowska"  , "98273012345", "AA1234573", "1998-07-30"  , "Michal"      , "Marja");

INSERT INTO
    checked_in(personal_data_id, old_address, new_address, check_in_date)
VALUES
    (1, 3   , 2, "2012-09-13"),
    (2, NULL, 3, "1999-03-11"),
    (5, NULL, 7, "2005-01-30"),
    (7, NULL, 6, "2019-12-03"),
    (4, NULL, 4, "2012-07-19"),
    (6, NULL, 2, "2009-06-30"),
    (3, NULL, 1, "2010-05-02");

INSERT INTO
    electoral_register(personal_data_id, date_of_receipt_of_voting_rights, constituency)
VALUES
    (1,"2018-01-02","Województwo dolnośląskie - Okręg wyborczy nr  1  (Legnica)"),
    (2,"1996-09-22","Województwo dolnośląskie - Okręg wyborczy nr  2  (Wałbrzych)"),
    (3,"2006-05-21","Województwo dolnośląskie - Okręg wyborczy nr  3  (Wrocław)"),
    (4,"2022-06-14","Województwo dolnośląskie - Okręg wyborczy nr  1  (Legnica)"),
    (5,"2011-05-0" ,"Województwo dolnośląskie - Okręg wyborczy nr  3  (Wrocław)"),
    (6,"2005-02-01","Województwo dolnośląskie - Okręg wyborczy nr  1  (Legnica)"),
    (7,"2016-07-30","Województwo dolnośląskie - Okręg wyborczy nr  2  (Wałbrzych)");

INSERT INTO
    users(email, password, role)
VALUES
    ("maciejnowak1983@wp.pl"        , "1234", "USER"),
    ("maciejnowak1983@onet.pl"      , "1235", "EMPLOYEE"),
    ("kamilBorowski1983@gmaile.com" , "1236", "EMPLOYEE"),
    ("polskagola1983@wp.pl"         , "1237", "USER"),
    ("szymonkrawczyk1983@wp.pl"     , "1238", "USER"),
    ("jakubciecira1983@wp.pl"       , "1239", "USER"),
    ("aleksandradobosz1983@wp.pl"   , "1230", "USER");

INSERT INTO
    application (personal_data_id, address_id, date_of_application, result, justification, submitting_user)
VALUES
    (1, 1, "2018-01-02", "POSITIVE", "essa", 1),
    (2, 2, "2018-01-02", "POSITIVE", "essa", 1),
    (3, 3, "2018-01-02", "POSITIVE", "essa", 1),
    (4, 3, "2018-01-02", "NEGATIVE", "essa", 1);