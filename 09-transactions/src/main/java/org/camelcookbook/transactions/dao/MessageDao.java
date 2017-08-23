/*
 * Copyright (C) Scott Cranton, Jakub Korab, and Christian Posta
 * https://github.com/CamelCookbook
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.camelcookbook.transactions.dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Utility class for accessing the <code>messages</code> table used in the database examples.
 */
public class MessageDao {

    private final JdbcTemplate jdbcTemplate;

    public MessageDao(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public int getMessageCount(String message) {
        return jdbcTemplate.queryForObject("select count(*) from messages where message = ?", Integer.class, message);
    }
}