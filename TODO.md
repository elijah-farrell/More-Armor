# MoreArmor TODO

## Completed Tasks
- [x] Inspect config registration in MoreArmor.java and ModConfigs.java
- [x] Verify armor code reads from config, not hardcoded defaults
- [x] Add logging for config fallback scenarios

## In Progress
- [ ] Test that changing run/config/morearmor-common.toml updates armor values

## Pending
- [ ] Ensure config spec is registered and saved to morearmor-common.toml

## Notes
- Added dynamic attribute override in DefaultArmorItem to read live config values
- Updated all special armor items to extend DefaultArmorItem
- Added comprehensive logging for config fallback scenarios
- Config changes should now apply at runtime without requiring restart
