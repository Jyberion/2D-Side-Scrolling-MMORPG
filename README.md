# 2D Side-Scrolling MMORPG

Welcome to the 2D Side-Scrolling MMORPG project! This open-source MMORPG brings together the excitement of role-playing games with the charm of classic 2D side-scrollers. Dive into a vibrant world, embark on epic quests, and join a community of players on this journey!

## Table of Contents

1. [Introduction](#introduction)
2. [Features](#features)
3. [Inspiration](#inspiration)
4. [Positions Needed](#positions-needed)
5. [Server Structure](#server-structure)
6. [Client Structure](#client-structure)
7. [License](#license)
8. [Community](#community)
9. [Credits](#credits)

## Introduction

This project aims to provide a fully functional MMORPG experience in a 2D side-scrolling environment. Players can explore diverse terrains, battle various enemies, and interact with other players in real-time. The game features a robust system for character development, item acquisition, and quest completion.

## Features

- **Rich Storyline**: Embark on an immersive adventure with a compelling narrative.
- **Character Customization**: Customize your avatar with various outfits, weapons, and accessories.
- **Diverse Classes**: Choose from multiple character classes, each with unique abilities and playstyles.
- **Dynamic Combat System**: Engage in real-time combat with a variety of enemies and bosses.
- **Quests and Missions**: Complete quests to earn rewards and progress through the game.
- **Multiplayer Interaction**: Team up with friends or meet new players to tackle challenges together.
- **Crafting and Trading**: Craft powerful items and trade with other players to enhance your gameplay.
- **Regular Updates**: Expect new content, features, and improvements regularly.

## Inspiration

The inspiration behind this project comes from a love for both classic 2D side-scrolling games and the immersive worlds of MMORPGs. Games like MapleStory, Terraria, and Ragnarok Online have significantly influenced the development of this project. We wanted to combine the engaging platforming mechanics of side-scrollers with the deep, social experience of MMORPGs. Our goal is to create a nostalgic yet fresh game that captures the essence of these beloved genres while introducing new and exciting elements for players to enjoy.

## Positions Needed

We are actively seeking talented individuals to join our team. Here are the positions currently open:

- **Java Developers**: Skilled in Java and experienced in modular development, particularly for game servers and clients.
- **Graphic Artists**: Proficient in creating 2D sprites, animations, and background art.
- **Sound Designers**: Experience in creating and integrating sound effects and music for games.
- **Level Designers**: Creative individuals who can design engaging and challenging levels.
- **Writers**: Talented storytellers to develop quests, dialogues, and lore.
- **Community Managers**: People who can engage with the community, manage social media, and organize events.

If you're interested in any of these positions, please contact us via email or join our Discord server.

## Server Structure

The server structure for the 2D Side-Scrolling MMORPG is designed to be modular, scalable, and maintainable. Here's an overview of the main components, using both Netty and KryoNet for networking:

- **Authentication Server**: Handles user login, registration, and authentication processes.
  - **Key Classes**: AuthServer, UserManager, SessionManager
  - **Libraries**: Spring Security, Netty, KryoNet

- **Game Logic Server**: Manages game rules, character actions, and interactions.
  - **Key Classes**: GameServer, CharacterManager, QuestManager, CombatManager
  - **Libraries**: LibGDX, jMonkeyEngine, Netty, KryoNet

- **World Server**: Manages the overall game world, including level data, NPCs, and environmental interactions.
  - **Key Classes**: WorldServer, NPCManager, EnvironmentManager
  - **Libraries**: JSON, XML, Netty, KryoNet

- **Channel Server**: Manages specific channels within the game world, similar to how MapleStory handles multiple channels for better load balancing and player distribution.
  - **Key Classes**: ChannelServer, ChannelManager
  - **Libraries**: Netty, KryoNet

- **Chat Server**: Manages all in-game communication, including private messages, group chats, and public channels.
  - **Key Classes**: ChatServer, MessageHandler, ChatManager
  - **Libraries**: Netty, KryoNet

- **Database Server**: Manages data storage and retrieval for user data, game state, and other persistent information using MySQL.
  - **Key Classes**: DatabaseServer, UserRepository, GameDataRepository
  - **Libraries**: Hibernate, Spring Data JPA, MySQL, HikariCP, Netty, KryoNet

- **API Server**: Provides RESTful APIs for various game services, enabling integration with external tools, websites, and applications.
  - **Key Classes**: ApiServer, ApiController, ApiService
  - **Libraries**: Spring Boot, Spring MVC, Netty, KryoNet

- **Admin Server**: Provides tools for administrators to manage the game, monitor server health, and perform maintenance tasks.
  - **Key Classes**: AdminServer, AdminDashboard, LogManager
  - **Libraries**: Spring Boot, Thymeleaf, Netty, KryoNet

- **Cash Shop Server**: Manages the in-game cash shop where players can purchase virtual items using real or in-game currency.
  - **Key Classes**: CashShopServer, PurchaseManager, ItemCatalog
  - **Libraries**: Spring Boot, Hibernate, Netty, KryoNet, HikariCP

## Client Structure

The client structure for the 2D Side-Scrolling MMORPG is designed to provide a seamless and immersive user experience. Here's an overview of the main components:

- **Main Client Application**: The core application that initializes and runs the game client.
  - **Key Classes**: GameClient, ClientLauncher
  - **Libraries**: LibGDX

- **User Interface (UI)**: Manages all visual elements and interactions within the game.
  - **Key Classes**: UIManager, HUD, InventoryUI, ChatUI
  - **Libraries**: Scene2D (part of LibGDX)

- **Networking**: Handles communication between the client and various game servers.
  - **Key Classes**: NetworkClient, PacketHandler, ConnectionManager
  - **Libraries**: Netty, KryoNet

- **Graphics and Rendering**: Manages the rendering of game graphics, including sprites, animations, and visual effects.
  - **Key Classes**: Renderer, SpriteManager, AnimationManager
  - **Libraries**: LibGDX

- **Audio**: Manages all in-game sound effects and music.
  - **Key Classes**: AudioManager, SoundEffect, MusicTrack
  - **Libraries**: LibGDX

- **Input Handling**: Manages player input from keyboard, mouse, and other input devices.
  - **Key Classes**: InputManager, KeyBindings, MouseHandler
  - **Libraries**: LibGDX

- **Game Logic**: Manages client-side game logic, including player actions, interactions, and local game state.
  - **Key Classes**: PlayerController, NPCController, GameStateManager
  - **Libraries**: LibGDX

- **Resource Management**: Handles loading and management of game assets such as textures, sounds, and data files.
  - **Key Classes**: AssetManager, ResourceLoader
  - **Libraries**: LibGDX

## License

This project is licensed under the GNU General Public License v3.0. See the LICENSE file for details.

## Community

Join our community to discuss the game, share your ideas, and get support:

- [Discord-Coming Soon](#)

## Credits

This project was created by Jyberion and the amazing contributors. Special thanks to all the open-source libraries and tools used in this project.

Thank you for being a part of the 2D Side-Scrolling MMORPG project. We hope you enjoy playing and contributing to the game as much as we enjoyed creating it!
