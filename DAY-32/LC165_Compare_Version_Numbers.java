class Solution {
    public int compareVersion(String version1, String version2) {
        String[] parts1 = version1.split("\\.", -1);
        String[] parts2 = version2.split("\\.", -1);

        int length = Math.max(parts1.length, parts2.length);

        for (int i = 0; i < length; i++) {
            long part1 = i < parts1.length ? Long.parseLong(parts1[i]) : 0L;
            long part2 = i < parts2.length ? Long.parseLong(parts2[i]) : 0L;

            if (part1 < part2) {
                return -1;
            }
            if (part1 > part2) {
                return 1;
            }
        }

        return 0;
    }
}