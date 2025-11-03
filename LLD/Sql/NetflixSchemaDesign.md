/**
Design Database Schema for a system like Netflix with the following Use Cases. You can draw it on pen and paper and upload the image of your solution.

Use Case:
    - Netflix has users
    - Every user has an email and a password
    - Users can create profiles to have separate independent environments.
    - Each profile has a name and a type. Type can be KID or ADULT.
    - There are multiple videos on Netflix.
    - For each video, there will be a title, description and a cast.
    - A cast is a list of actors who were a part of the video. For each actor, we need to know their name and list of videos they were a part of.
    - For every video, for any profile who watched that video, we need to know the status (COMPLETED/ IN PROGRESS).
    - For every profile for whom a video is in progress, we want to know their last watch timestamp.
 */

class Netflix {
    user: User[]
    video: Video[]
}


class User {
    attributes:
        id: string
        email: string
        password: string
        profile: Profile[]
    
    methods:
        createProfile(profileType: ProfileType): Profile
}

class Profile {
    attributes:
        id: string
        name: string
        type: ProfileType
        video: Video[]
    
    methods:
        getLastWatch(videoId: string): Date
}



class Video {
    attributes:
        id: string
        title: string
        description: string
        cast: Cast[]
}


class Cast {
    attributes:
        id: string
        name: string
    
    methods:
        getVideos(castId: string): Video[]
}

class ProfileVideoMapping {
    attributes:
        profile: Profile
        video: Video
        status: Status
        lastWatched: Date
    
    methods:
        getVideoStatus(profileId: string, videoId: string): Status
}

class ProfileType {
    attributes:
        id: string
        typeName: string
}

class Status {
    attributes:
        id: string
        statusName: string
}