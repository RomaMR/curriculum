package com.curriculum.web.config;

public interface API {

    String ROOT = "/api";
    String ID = "/{id}";

    interface User {
        String ROOT = API.ROOT + "/users";
        String EMAIL = "/email/{email}";
        String CURRENT = "/current";
        String ROLE = API.ID + "/role";
        String PASSWORD = API.ID + "/password";
    }
    interface Curriculum {
        String ROOT = API.ROOT + "/curriculums";
        String PREVIEWS = "/previews";
    }

    interface Authentication {
        String ROOT = API.ROOT + "/authentications";
    }

    interface Constants {
        String ROOT = API.ROOT + "/constants";
    }

    interface Headers {
        interface Cookie {
            String TOKEN = "X-Auth-Token";
        }
    }
}
