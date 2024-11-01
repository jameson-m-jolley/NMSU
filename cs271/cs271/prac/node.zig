const u8Node = struct {
    data: u8,
    next: ?*u8Node = null,

    pub fn init(data: u8) u8Node {
        return u8Node{
            .data = data,
            .next = null,
        };
    }
};

const std = @import("std");

pub fn main() !void {
    var head = u8Node.init(5);
    var secondNode = u8Node.init(10);
    head.next = &secondNode; // Linking the second node to the head

    const stdout = std.io.getStdOut().writer();
    try stdout.print("Hello, {s}!\n", .{"world"});
    try stdout.print("{d}", .{head.data});
}
