SUMMARY = "bitbake-layers recipe"
DESCRIPTION = "Wayland compositor"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit qt6-cmake

SRC_URI = "file://*"

DEPENDS += " qtbase \
             qtdeclarative-native \
             qtquick3d"

#runtime dependancy for visualization over wayland api
RDEPENDS_${PN} += "qtwayland"

S = "${WORKDIR}"

