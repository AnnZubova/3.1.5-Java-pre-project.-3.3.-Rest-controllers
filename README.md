Информация по запуску приложения
1. Запустить приложение
2. Нужно добавить роли пользователей в таблицу roles:
INSERT INTO roles(id, role)
  VALUES (1, 'ROLE_USER'), (2, 'ROLE_ADMIN'); 
3. Регистрируем в базе данных одного пользователя (пароль будет назначен '100' без кавычек): INSERT INTO public.users (id, age, email, first_name, last_name, password) VALUES (1, 55, 'admin@gmail.com', 'admin', 'admin','$2a$12$J50zihjR.M.foOg6lJ8hdeu3SZc1myn7px6V1fSQhCcs7pwV5U9Ui')
4. После добавления нового пользователя, добавьте в таблицу пользователь-роли запись, дающую эту роль:
INSERT INTO users_roles(user_id, role_id)
  VALUES (1, 2);
