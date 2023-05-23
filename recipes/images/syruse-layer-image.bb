require recipes-core/images/core-image-minimal.bb
INHERIT += "rm_work"
RM_WORK_EXCLUDE += "syruse-layer"

EXTRA_IMAGE_FEATURES += "debug-tweaks"
EXTRA_IMAGE_FEATURES += "tools-debug"

DISTRO_FEATURES:append = "systemd opengl egl wayland"
DISTRO_FEATURES:remove = " x11"
CORE_IMAGE_EXTRA_INSTALL += "wayland weston"
#disable undesired init manager "sysvinit"
DISTRO_FEATURES_BACKFILL_CONSIDERED = "sysvinit"
INIT_MANAGER = "systemd"

IMAGE_NAME = "syruse-layer"

IMAGE_INSTALL:append = " qtbase qtbase-plugins qtwayland"
IMAGE_INSTALL:append = " syruse-layer"

