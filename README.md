
# CraftCancel Plugin

CraftCancel is a Minecraft server plugin that allows you to disable crafting for specific items. The plugin is built on the Paper API and uses the powerful [Configurate](https://github.com/SpongePowered/Configurate) library for configuration management.

## Features

- Block crafting of specific items as defined in the configuration file.
- Lightweight and easy to configure.
- Uses the HOCON configuration format for flexible and human-readable configuration.

## Requirements

- Minecraft server running on [Paper](https://papermc.io/) 1.21.3 or later.
- Java 21 or higher.

## Installation

1. **Download the Plugin**  
   Download the latest version of the plugin from the [Releases](https://github.com/TofaDev/craft-cancel/releases) section.

2. **Place the Plugin**  
   Copy the downloaded `.jar` file into the `plugins` folder of your Minecraft server.

3. **Start the Server**  
   Start your server. The plugin will generate a default configuration file if one does not exist.

4. **Edit the Configuration**  
   Edit the `config.conf` file located in the `plugins/CraftCancel` folder to define the items you want to disable crafting for.

## Configuration

The configuration file (`config.conf`) uses the HOCON format and looks like this:

```hocon
disabled-crafts: [
  "wooden_sword",
  "golden_apple"
]
```

- Add the names of items you want to disable crafting for in the `disabled-crafts` list.
- Use the exact `Material` names from the Minecraft API (case-insensitive).

## Example Usage

If you disable crafting for `wooden_sword` and `golden_apple`, players attempting to craft these items will see their crafting recipes disabled.

## Development

This plugin is built using Gradle. To build the plugin locally:

1. Clone the repository:
   ```bash
   git clone https://github.com/TofaDev/craft-cancel
   cd CraftCancel
   ```

2. Build the plugin:
   ```bash
   gradle shadowJar
   ```

3. The compiled `.jar` file will be available in the `build/libs` folder.

## Contributing

Contributions are welcome! If you'd like to contribute:

1. Fork the repository.
2. Create a feature branch.
3. Submit a pull request with a clear description of your changes.

## License

This project is licensed under the [MIT License](LICENSE).
