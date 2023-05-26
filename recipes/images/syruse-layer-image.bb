require recipes-core/images/core-image-minimal.bb
INHERIT += " rm_work "
RM_WORK_EXCLUDE += " syruse-layer "

EXTRA_IMAGE_FEATURES += "debug-tweaks"
EXTRA_IMAGE_FEATURES += "tools-debug"

IMAGE_NAME = "syruse-layer"

IMAGE_INSTALL:append = " qtbase qtbase-plugins qtwayland "
IMAGE_INSTALL:append = " syruse-layer syruse-layer-compositor "
IMAGE_INSTALL:append = " openssh "
