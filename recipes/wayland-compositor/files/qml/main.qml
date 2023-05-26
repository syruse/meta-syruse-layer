import QtQuick
import QtQuick.Window
import QtWayland.Compositor
import QtWayland.Compositor.XdgShell
import QtWayland.Compositor.WlShell
import QtWayland.Compositor.IviApplication

WaylandCompositor {

    WaylandOutput {
        sizeFollowsWindow: true
        window: Window {
            width: 1024
            height: 768
            visible: true

            Repeater {
                model: shellSurfaces
                // ShellSurfaceItem handles displaying a shell surface.
                // It has implementations for things like interactive
                // resize/move, and forwarding of mouse and keyboard
                // events to the client process.
                ShellSurfaceItem {
                    shellSurface: modelData
                    onSurfaceDestroyed: shellSurfaces.remove(index)
                }
            }
        }
    }

    // Extensions are additions to the core Wayland
    // protocol. We choose to support three different
    // shells (window management protocols). When the
    // client creates a new shell surface (i.e. a window)
    // we append it to our list of shellSurfaces.

    WlShell {
        onWlShellSurfaceCreated:
            shellSurfaces.append({shellSurface: shellSurface});
    }
    XdgShell {
        onToplevelCreated:
            shellSurfaces.append({shellSurface: xdgSurface});
    }
    IviApplication {
        onIviSurfaceCreated: {
            shellSurfaces.append({shellSurface: iviSurface});
        }
    }

    ListModel { id: shellSurfaces }
}
